from odoo import models, fields

class Auteur(models.Model):
    _name = 'auteur'
    nom = fields.Char(string="Nom",required=True)
    prenom = fields.Char(string="Prénom",required=True)
    dateNaissance = fields.Date(string="dateNaissance")
    nationalite = fields.Char(string="nationalite", default="algerienne")
    sexe = fields.Selection([("homme", "Homme"), ("femme", "Femmme")])
    livre_ids = fields.Many2many('livre',String='Livre')