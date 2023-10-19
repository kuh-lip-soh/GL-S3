from odoo import models, fields


class Livre(models.Model):
    _name = 'livre'
    titre = fields.Char(string="titre", required=True)
    image_libre = fields.Char(string="image_libre")
    isbn = fields.Integer(string="isbn")
    nbr_pages = fields.Integer(string="nbr_pages")
    langue_livre = fields.Selection(
        [("arabic", "Arabic"), ("french", "French"), ("english", "English")]
    )
