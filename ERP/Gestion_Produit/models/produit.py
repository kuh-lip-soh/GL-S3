from odoo import models, fields

class Produit(models.Model):
    _name = 'produit'

    nom = fields.Char(string='Nom', required=True)
    reference = fields.Char(string='Référence')
    quantite = fields.Float(string='Quantité')
    unite_mesure = fields.Selection([('kg', 'Kilogramme'), ('g', 'Gramme'), ('mg', 'Milligramme')], string='Unité de Mesure')
    prix_kg = fields.Float(string='Prix par Kilogramme', required=True)

    depot_id = fields.Many2one('depot', string='Dépôt')
    fournisseur_id = fields.Many2one('fournisseur', string='Fournisseur')

    def compute_prix(self):
        if self.unite_mesure == 'kg':
            return self.prix_kg * self.quantite
        elif self.unite_mesure == 'g':
            return self.prix_kg * (self.quantite / 1000)
        elif self.unite_mesure == 'mg':
            return self.prix_kg * (self.quantite / 1000000)
        else:
            return 0