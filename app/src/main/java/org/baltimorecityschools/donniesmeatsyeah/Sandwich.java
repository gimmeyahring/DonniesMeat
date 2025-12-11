package org.baltimorecityschools.donniesmeatsyeah;

public class Sandwich {

    String meatType;
    String sauseType;
    boolean mayoBool;
    boolean cheeseBool;
    int quantity;
    public final double BASE_PRICE = 3.00;
    double price;

    public Sandwich(){
        meatType = "None";
        sauseType = "None";
        mayoBool = false;
        cheeseBool = false;
        quantity = 0;
        price = BASE_PRICE;
    }
    public Sandwich(String mtf, String stf, boolean mbf, boolean cbf, int qf){
        meatType = mtf;
        sauseType = stf;
        mayoBool = mbf;
        cheeseBool = cbf;
        quantity = qf;


        calculatePrice();
    }
    public String getMeatType(){return meatType;}
    public String getSauseType(){return sauseType;}
    public boolean getMayoBool(){return mayoBool;}
    public boolean getCheeseBool(){return cheeseBool;}
    public int getQuantity(){return quantity;}
    public double getPrice(){return price;}

    public void setMeatType(String meatType) {this.meatType = meatType; calculatePrice();}

    public void setSauseType(String sauseType) {this.sauseType = sauseType; calculatePrice();}

    public void setMayoBool(boolean mayoBool) {this.mayoBool = mayoBool; calculatePrice();}

    public void setCheeseBool(boolean cheeseBool) {this.cheeseBool = cheeseBool; calculatePrice();}

    public void setQuantity(int quantity) {this.quantity = quantity; calculatePrice();}

    @Override
    public String toString() {
        return "Sandwich{" +
                "meatType='" + meatType + '\'' +
                ", sauseType='" + sauseType + '\'' +
                ", mayoBool=" + mayoBool +
                ", cheeseBool=" + cheeseBool +
                ", quantity=" + quantity +
                ", BASE_PRICE=" + BASE_PRICE +
                ", price=" + price +
                '}';
    }

    private void calculatePrice(){
        price = BASE_PRICE;
        if (meatType == "chicken"){
            price = price + 2.0;
        }
        else if (meatType == "ham"){
            price = price + 1.0;
        }
        else if (meatType == "turkey"){
            price = price + 1.0;
        }

        price = price*quantity;
    }

}
