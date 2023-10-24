from odoo import models, fields

class Emprunteur(models.Model):
    _name = 'emprunteur'
    nom = fields.Char(string="nom")
    prenom = fields.Char(string="prenom")
    dateNaissance = fields.Date(string="dateNaissance")
    state = fields.Char(string="state")
    sexe = fields.Selection([("homme", "Homme"), ("femme", "Femmme")])
    emprunt_ids=fields.One2many('emprunt','emprunteur_id',String='emprunt')
