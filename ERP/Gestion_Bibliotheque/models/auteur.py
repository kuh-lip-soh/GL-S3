from odoo import models, fields, api


class Auteur(models.Model):
    _name = "auteur"
    _rec_name = "nom"
    nom = fields.Char(String="Nom", required=True)
    prenom = fields.Char(String="Prénom", required=True)
    date_naissance = fields.Date(String="Date de naissance")
    nationalite = fields.Many2one("res.country", string="country")
    sexe = fields.Selection([("homme", "Homme"), ("femme", "Femme")])
    livres = fields.Many2many("livre", string="Livres")
    nbrs_emprunts = fields.Float(String="nbrs_emprunts", compute="_compute_nbrs_emprunts")

    @api.depends("livres")
    def _compute_nbrs_emprunts(self):
        for record in self.livres:
            livre_ids = self.env["empruntligne"].search([("livres", "=", record.id)])
            self.nbrs_emprunts = self.nbrs_emprunts + len(livre_ids)

    # @api.depends("livres")
    # def _compute_nbrs_emprunts(self):
    #     for record in self:
    #         for rec in record.livres:
    #             if rec.emprunt_lignes:
    #                 record.nbrs_emprunts = record.nbrs_emprunts + len(rec.emprunts)

    # @api.depends("livres")
    # def _compute_nbrs_emprunts(self):
    #     record.nbrs_emprunts = 0
