from odoo import models, fields


class Livre(models.Model):
    _name = "livre"
    _rec_name = "titre"
    titre = fields.Char(String="Titre", required=True)
    isbn = fields.Char(String="isbn", required=True)
    nbre_pages = fields.Float(String="nbre_pages")
    image_livre = fields.Binary(String="image")
    langue_livre = fields.Selection(
        [("français", "FR"), ("Arabe", "ARB"), ("Anglais", "ENG")]
    )
    auteurs = fields.Many2many("auteur", string="Auteurs")
    emprunt_lignes = fields.One2many("empruntligne", "livres", string="emprunt_ligne")
