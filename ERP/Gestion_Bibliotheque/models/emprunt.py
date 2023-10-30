# -*- coding: utf-8 -*-
from odoo import models, fields, api
from datetime import date

class Emprunt(models.Model):
    _name = 'emprunt'
    date_debut = fields.Date(string="Date debut",  compute="autoStartDate")
    date_fin = fields.Date(string="Date fin")
    rendu = fields.Selection([
        ('oui','Oui'),
        ('non','Non')
        ],  compute="autoRendu")
    emprunteur_id = fields.Many2one('emprunteur', string="Emprunteur")
    emprunt_ligne_ids = fields.One2many('emprunt_ligne', "emprunt_id", string="Emprunt Lignes")

    @api.depends('date_fin')
    def autoRendu(self):
        for rec in self:
            if rec.date_fin == date.today():
                rec.rendu = 'oui'
            else:
                rec.rendu = 'non'

    @api.depends('date_fin')
    def autoStartDate(self):
        for rec in self:
            rec.date_debut = date.today()