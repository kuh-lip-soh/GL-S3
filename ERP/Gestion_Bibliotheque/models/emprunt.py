from odoo import models, fields, api
from datetime import date


class Emprunt(models.Model):
    _name = "emprunt"
    _rec_name = "emprunteur"

    date_debut = fields.Date(String="Date debut", compute="_date_debut")
    date_fin = fields.Date(String="Date fin")
    rendu = fields.Selection([("oui", "Oui"), ("non", "Non")])
    emprunteur = fields.Many2one("emprunteur", string="Emprunteur")
    emprunt_ligne = fields.One2many("empruntligne", "emprunts", string="Emprunt_ligne")

    @api.onchange("date_fin")
    def _change_rendu(self):
        if self.date_fin and self.date_fin == date.today():
            self.rendu = "oui"
        else:
            self.rendu = "non"

    @api.depends("date_debut")
    def _date_debut(self):
        for record in self:
            record.date_debut = date.today()
