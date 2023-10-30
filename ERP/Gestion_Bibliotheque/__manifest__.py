# -*- coding: utf-8 -*-
# Part of Odoo. See LICENSE file for full copyright and licensing details.

{
    'name': 'Gestion de bibliothèque',
    'version': '1.0',
    'category': 'bibliotheque',
    'author': "OUAFI Mohammed Zakaria",
    'depends': ["project"],
    'data':['views/auteur.xml',
           'views/livre.xml', 
           'views/emprunt.xml',
           'views/emprunteur.xml',
           'views/emprunt_ligne.xml',
           'security/ir.model.access.csv'],
    'description': "Ce module est destiné pour la gestion de bibliothèques",
    'installable': True,
    'application': True,
    'auto_install': False,
   
}
