from odoo import models, fields

class Depot(models.Model):
    _name = 'depot'

    nom = fields.Char(string='Nom', required=True)
    adresse = fields.Char(string='Adresse')
    quantite_produit = fields.Float(string='Quantité de Produit')

    fournisseurs_ids = fields.One2many('fournisseur', 'depot_id', string='Fournisseurs')
    produits_ids = fields.One2many('produit', 'depot_id', string='Produits')

    @api.depends('produits_ids.quantite')
    def _compute_quantite_produit(self):
        for depot in self:
            quantite_produit = sum(depot.produits_ids.mapped('quantite'))
            depot.quantite_produit = quantite_produit