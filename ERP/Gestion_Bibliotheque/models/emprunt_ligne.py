# -*- coding: utf-8 -*-
from odoo import models, fields, api

class Emprunt_ligne(models.Model):
    _name = 'emprunt_ligne'
    emprunt_id = fields.Many2one('emprunt', string="Emprunts")
    livre_id = fields.Many2one('livre', string="Livres")
    isbn = fields.Char(string="ISBN")
    nbre_pages = fields.Integer(string="Nombre des pages")
    langue_livre = fields.Selection([
        ('francais','Francais'),
        ('arabe','Arabe'),
        ('anglais','Anglais')
        ])
    
    @api.onchange('livre_id')
    def remplierChamps(self):
        for record in self:
            if record.livre_id:
                record.isbn=record.livre_id.isbn
                record.nbre_pages=record.livre_id.nbre_pages
                record.langue_livre=record.livre_id.langue