from odoo import models, fields


class Emprunt(models.Model):
    _name = 'emprunt'
    date_debut = fields.Date(string="date_debut", required=True)
    date_fin = fields.Date(string="date_fin", required=True)
    rendu = fields.Selection([("oui", "Oui"), ("Non", "Non")])
