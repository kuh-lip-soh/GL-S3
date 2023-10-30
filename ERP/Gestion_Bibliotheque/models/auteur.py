# -*- coding: utf-8 -*-
from odoo import models, fields, api

class Auteur(models.Model):
    _name = 'auteur'
    _rec_name = 'nom'
    livres = fields.Many2many('livre', string='Livre Ecrit')
    nom = fields.Char(string="Nom")
    prenom = fields.Char(string="Prenom")
    date_naissance = fields.Date(string="Date de naissance")
    nationalite = fields.Char(string="Nationalite", default="Algerienne")
    sexe = fields.Selection([
        ('homme','Homme'),
        ('femme','Femme')
        ])
