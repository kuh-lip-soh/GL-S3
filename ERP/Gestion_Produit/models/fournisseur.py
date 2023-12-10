from odoo import models, fields

class Fournisseur(models.Model):
    _name = 'fournisseur'

    nom = fields.Char(string='Nom', required=True)
    prenom = fields.Char(string='Prénom', required=True)
    prix_total = fields.Float(string='Prix Total', compute='_compute_prix_total', store=True, required=True)

    depot_id = fields.Many2one('depot', string='Dépôt')
    produits_ids = fields.One2many('produit', 'fournisseur_id', string='Produits')

    @api.depends('produits_ids')
    def _compute_prix_total(self):
        for fournisseur in self:
            prix_total = sum(produit.compute_prix() for produit in fournisseur.produits_ids)
            fournisseur.prix_total = prix_total