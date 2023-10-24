from odoo import models, fields

class Empruntligne(models.Model):
	_name='empruntligne'
	ligne=fields.Char(String="Ligne")
	livres=fields.Many2one('livre',String='livre')
	emprunts=fields.Many2one('emprunt',String='emprunt')