from odoo import api, fields, models


class EmpruntWizard(models.TransientModel):
    _name = "emprunt.wizard"

    date_debut = fields.Date(String="Date debut")
    date_fin = fields.Date(String="Date fin")
    rendu = fields.Selection([("oui", "Oui"), ("non", "Non")])
    emprunteur = fields.Many2one("emprunteur", string="Emprunteur")
    # livres = fields.Many2one("livres", string="Emprunteur")
    ligne = fields.One2many("ligne_wizard", "emprunts", string="emprunts")

    @api.multi
    def réinitialiser_emprunteur(self):
        for record in self.emprunteur:
            record_to_delete = self.env["emprunt"].search(
                [("emprunteur", "=", record.id)]
            )
            record_to_delete.unlink()

    @api.multi
    def ajouter_emprunts(self):
        emprunt_lignes = []
        for i in self.ligne:
            emprunt_lignes.append(
                (
                    0,
                    0,
                    {
                        "isbn": i.isbn,
                        "nbre_pages": i.nbre_pages,
                        "langue_livre": i.langue_livre,
                        "livres": i.livres.id,
                    },
                )
            )

        # new_emprunt.write({"emprunt_ligne": [(6, 0, emprunt_lignes)]})

        data = {
            "date_debut": self.date_debut,
            "date_fin": self.date_fin,
            "rendu": self.rendu,
            "emprunteur": self.emprunteur.id,
            "emprunt_ligne": emprunt_lignes,
        }

        return self.env["emprunt"].create(data)
