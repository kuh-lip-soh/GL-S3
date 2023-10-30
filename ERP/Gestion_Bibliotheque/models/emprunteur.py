# -*- coding: utf-8 -*-
from odoo import models, fields, api

class Emprunteur(models.Model):
    _name = 'emprunteur'
    _rec_name='nom'
    nom = fields.Char(string="Nom")
    prenom = fields.Char(string="Prenom")
    date_naissance = fields.Date(string="Date de naissance")
    state = fields.Char(string="State")
    sexe = fields.Selection([
        ('homme','Homme'),
        ('femme','Femme')
        ])
    nbr_emprunt = fields.Integer(string="Nbr Emprunts", compute="calculerEmprunts")
    emprunt_ids = fields.One2many("emprunt", "emprunteur_id", string="Emprunts")

    @api.depends('emprunt_ids')
    def calculerEmprunts(self): 
        for record in self:
            record.nbr_emprunt = len(record.emprunt_ids)