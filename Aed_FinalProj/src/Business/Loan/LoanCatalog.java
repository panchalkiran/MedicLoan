/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Loan;

import java.util.ArrayList;

/**
 *
 * @author Kiran
 */
public class LoanCatalog {
    
    private ArrayList<Loan> loanCatalog;
    
    public LoanCatalog()
    {
        loanCatalog= new ArrayList<>();
    }

    public ArrayList<Loan> getLoanCatalog() {
        return loanCatalog;
    }

    public void setLoanCatalog(ArrayList<Loan> loanCatalog) {
        this.loanCatalog = loanCatalog;
    }
    
    public Loan createAndAddLoan(){
        Loan loan = new Loan();
        loanCatalog.add(loan);
        return loan;
    }
}
