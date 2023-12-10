from odoo import models, fields, api


class Emprunteur(models.Model):
    _name = "emprunteur"
    _rec_name = "nom"
    nom = fields.Char(String="Nom", required=True)
    prenom = fields.Char(String="Prenom", required=True)
    date_naissance = fields.Date(String="Date Naissance")
    state = fields.Char(String="State")

    sexe = fields.Selection([("homme", "Homme"), ("femme", "Femme")])
    emprunts = fields.One2many("emprunt", "emprunteur", string="Emprunts")
    nbrs_emprunts = fields.Integer(
        String="nbrs_emprunts", compute="_compute_nbrs_emprunts"
    )

    @api.depends("emprunts")
    def _compute_nbrs_emprunts(self):
        for record in self:
            if record.emprunts:
                record.nbrs_emprunts = len(record.emprunts)

    # nbr_emprunts = fields.Integer(String="nbr_emprunts", compute="_compute_emprunts")

    # @api.depends("emprunts")
    # def _compute_emprunts(self):
    #     self.nbr_emprunts = 10

    #     # if self.emprunts:
    #     #     self.nbre_emprunt = 5
    #     # else:

    # nbre_emprunt = fields.Integer(String="nbre_emprunt", compute="compute_emprunts")
