import datetime
from datetime import datetime

from odoo import fields, models, api

class Participant(models.Model):
    _name = 'hamadi_mohammed.patient'
    _rec_name = "nom"
    matricule = fields.Char(string='Matricule', required=True)
    nom = fields.Char(string='Nom', required=True)
    date_naissance = fields.Date(string='Date de naissance',required = True)
    age = fields.Char(string="Age",required =True, compute='_compute_age')
    genre = fields.Selection(string="Genre", selection=[('masculin','Masculin'), ('feminin','Féminin') ], required=True )
    nbr_medicament = fields.Integer(string="Nbr de medicaments", required=True,compute="total_medicament" )

    consultations_ids = fields.One2many(comodel_name="hamadi_mohammed.consultation", inverse_name="patient_id", string="Les consultations", required=False )

    _sql_constraints = [
        ('unique_mattricule_patient_constraint', 'unique(matricule)', "La matricule doit être unique !"),
    ]

    @api.onchange('date_naissance')
    def _compute_age(self):
        if self.date_naissance:
            date = self.date_naissance
            current_year = datetime.strptime(date,'%Y-%m-%d')
            self.age=datetime.now().year-current_year.year
    @api.one
    @api.depends("consultations_ids")
    def total_medicament(self):
        total_med = 0
        for consultation in self.consultations_ids:
            total_med += len(consultation.medicament_ids)
        self.nbr_medicament = total_med