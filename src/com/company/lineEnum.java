package com.company;

public class lineEnum {


        public static enum Type {
            LINE(0,0,0,0),
            RECTANGLE(0,0,0,0),
            PLOT(0,0,0,0),
            ELLIPSE(0,0,0,0),
            POLYGON(0,0,0,0);

            private double x1;
            private double x2;
            private double y1;
            private double y2;


            Type(double x1,double y1,double x2,double y2) {
                this.x1 = x1;
                this.x2 = x2;
                this.y1 = y1;
                this.y2 = y2;

            }

            public double getX1() {
                return x1;
            }
            public double getY1() {
                return y1;
            }
            public double getX2() {
                return x2;
            }
            public double getY2() { return y2; }


        }



}
