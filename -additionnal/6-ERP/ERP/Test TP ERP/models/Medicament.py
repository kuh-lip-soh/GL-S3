from odoo import fields, models, api


class Medicament(models.Model):
    _name = 'hamadi_mohammed.medicament'

    libelle = fields.Char(string='Libelle', required=True)
    description = fields.Text(string="Description", required=False, )

    consultations_ids = fields.Many2many(comodel_name="hamadi_mohammed.consultation", string="Consultations",required=False )