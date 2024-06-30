from odoo import fields, models, api

class Consultation(models.Model):
    _name = 'hamadi_mohammed.consultation'
    _rec_name = "medecin"

    date = fields.Date(string="Date", required=False, )
    medecin = fields.Char(string='Medecin', required=True)
    poids = fields.Float(string="Poids", required=False)
    taille = fields.Float(string="Taille", required=False)
    motif = fields.Text(string="Motif", required=False, )
    imc = fields.Float(string="IMC", required=False,compute='compute_imc')

    medicament_ids = fields.Many2many(comodel_name="hamadi_mohammed.medicament", string="Medicaments",required=False)
    patient_id = fields.Many2one(comodel_name="hamadi_mohammed.patient", string="Patient", required=False, )

    @api.one
    def compute_imc(self):
        if self.poids and self.taille and self.patient_id:
            if self.patient_id.genre == 'masculin':
                self.imc=(self.poids/(self.taille*self.taille))*0.1
            else:
                self.imc = (self.poids / (self.taille * self.taille)) * 0.2


