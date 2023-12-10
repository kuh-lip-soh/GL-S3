from odoo import models, fields, api


class LigneWizard(models.TransientModel):
    _name = "ligne_wizard"

    isbn = fields.Char(String="isbn", required=True)
    nbre_pages = fields.Float(String="nbre_pages")
    langue_livre = fields.Selection(
        [("français", "FR"), ("Arabe", "ARB"), ("Anglais", "ENG")]
    )
    livres = fields.Many2one("livre", string="Livre")
    emprunts = fields.Many2one("emprunt.wizard", string="Emprunt")

    # @api.onchange("livre_ids")
    # def calculer_age(self):
    # for rec in self:
    #     if rec.isbn & rec.nbre_pages & rec.langue_livres:

    @api.onchange("livres")
    def update_livres(self):
        # self.isbn = 100
        for rec in self:
            if rec.livres:
                rec.isbn = rec.livres.isbn
                rec.nbre_pages = rec.livres.nbre_pages
                rec.langue_livre = rec.livres.langue_livre
