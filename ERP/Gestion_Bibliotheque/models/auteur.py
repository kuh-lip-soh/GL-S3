from odoo import models, fields


class Auteur(models.Model):
    _name = 'auteur'
    nom = fields.Char(string="Nom", required=True)
    prenom = fields.Char(string="Prenom", required=True)
    dateNaissance = fields.Date(string="dateNaissance")
    nationalite = fields.Char(string="nationalite", default="Algérienne")
    sexe = fields.Selection([("homme", "Homme"), ("femme", "Femmme")])
x