
import java.util.Date;

public class Lendemain {
Date date ;
    @SuppressWarnings("deprecation")
	public Date calcLendemain(int jour, int mois, int annee) {

        if (this.anneeValid(annee) && this.moisValid(mois) && this.jourValid(jour, mois, this.isAnneeBissextiles(annee))) {
            jour += 2;
            if (jour > this.moisL(mois, this.isAnneeBissextiles(annee))) {
                jour -= this.moisL(mois, this.isAnneeBissextiles(annee));
                mois++;
                if (mois > 12) {
                    mois -= 12;
                    annee++;
                }
            }
           date = new Date(annee,mois,jour);
            System.out.println("next day is " + jour + "/" + mois + "/" + annee);
            return date;
        } else throw new IllegalArgumentException("Input Invalid");

//        if (!this.anneeValid(annee)) throw new IllegalArgumentException("Annee invalid");
//        if (!this.moisValid(mois)) throw new IllegalArgumentException("Mois invalid");
//        if (!this.jourValid(jour, mois, this.isAnneeBissextiles(annee))) throw new IllegalArgumentException("Jour invalid");
    }

    public int moisL(int mois, boolean isBis) {
        switch(mois){
            case 1, 3, 5, 7, 8, 10, 12: {
                return 31;
            }

            case 4, 6, 9, 11: {
                return 30;
            }
            case 2 : {
                if (isBis) return 29;
                else return 28;
            }

            default: return -1;
        }
    }

    public boolean anneeValid(int annee) {
        if (annee < 1582 || annee > 3000) return false;
        return true;
    }

    public boolean moisValid(int mois) {
        if (mois < 1 || mois > 12) return false;
        return true;
    }

    public boolean jourValid(int jour, int mois, boolean isBis) {
        if (jour < 1) return false;

        switch(mois){
            case 1, 3, 5, 7, 8, 10, 12: {
                return jour <= 31;
            }

            case 4, 6, 9, 11: {
                return jour <= 30;
            }
            case 2 : {
                if (isBis && jour > 29) return false;
                else if (!isBis && jour > 28) return false;
                else return true;
            }
        }

        return false;
    }

    public Boolean isAnneeBissextiles(int annee){
        if((annee % 4 == 0 || annee % 400 == 0) && (annee%100 != 0)) return true;
        else return false;
    }
}
