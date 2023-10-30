# -*- coding: utf-8 -*-
from odoo import models, fields, api

class Livre(models.Model):
    _name = 'livre'
    _rec_name = 'titre'
    auteurs = fields.Many2many('auteur', string='Authors')
    emprunt_ligne_ids = fields.One2many('emprunt_ligne', "livre_id", string="Emprunt Lignes")
    titre = fields.Char(string="Titre")
    langue = fields.Selection([
        ('francais','Français'),
        ('arabe','Arabe'),
        ('anglais','Anglais')
        ])
    isbn = fields.Char(string="ISBN")
    nbre_pages = fields.Integer(string="Nombre des pages")
    image_libre = fields.Binary(string="Image libre")