package com.mygdx.game.ECSRemastered.utilities;

public class Vector7
{

    public float x, y;

    public Vector7(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector7(Vector7 vec) {
        setVec(vec);
    }

    //vector operations that modify the original
    public void set(Vector7 v)
    {
        x = v.x;
        y = v.y;
    }

    public Vector7 setVec(Vector7 vec){
            x = vec.x;
            y = vec.y;
        return this;
    }

    public void set(float Vx, float Vy)
    {
        x = Vx;
        y = Vy;
    }

    public void add(Vector7 v)
    {
        x += v.x;
        y += v.y;
    }

    public void add(double pX, double pY, double pZ)
    {
        x += pX;
        y += pY;
    }

    public void sub(Vector7 v)
    {
        x -= v.x;
        y -= v.y;
    }

    public void sub(double pX, double pY, double pZ)
    {
        x -= pX;
        y -= pY;

    }

    public void div(double val)
    {
        x /= val;
        y /= val;
    }

    public void mult(double val)
    {
        x *= val;
        y *= val;
    }


    public double dot(Vector7 v)
    {
        return x * v.x + y * v.y;
    }

    public void limit(double lim)
    {
        double mag = mag(this);
        if (mag != 0 && mag > lim)
        {
            x *= lim / mag;
            y *= lim / mag;
        }
    }
    public void normalize()
    {
        double mag = mag(this);
        if (mag != 0)
        {
            x /= mag;
            y /= mag;
        }
    }


    public void rotate(double angle_degrees)
    {
        double radians = Math.toRadians(angle_degrees);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        x = (float) (x * cos - y * sin);
        y = (float) (x * sin + y * cos);
    }



//----------------------------vector operations that don't modify the original-------------------------------------------------------------------------------//


    public Vector7 cpy () {
        return new Vector7(this);
    }

    public static Vector7 add(Vector7 v1, Vector7 v2) {
        float x = v1.x + v2.x;
        float y = v1.y + v2.y;
        return new Vector7(x, y);
    }


    public static Vector7 addAll(Vector7[] all) {
        Vector7 v = new Vector7(0, 0);
        for (Vector7 a : all) {
            v = Vector7.add(v, a);
        }
        return v;
    }

    public static Vector7 sub(Vector7 v1, Vector7 v2) {
        float x = v1.x - v2.x;
        float y = v1.y - v2.y;
        return new Vector7(x, y);
    }


    public static Vector7 mult(Vector7 v1, float s1) {
        float x = v1.x * s1;
        float y = v1.y * s1;
        return new Vector7(x, y);
    }

    public static Vector7 div(Vector7 v1, float s1) {
        float x = v1.x / s1;
        float y = v1.y / s1;
        return new Vector7(x, y);
    }

    public static double mag(Vector7 v1) {
        return Math.sqrt(Math.pow(v1.x, 2) + Math.pow(v1.y, 2));
    }

    public static double distanceBetweenTwoVectors(Vector7 v1, Vector7 v2)
    {
        return Math.sqrt(Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2));
    }

    public static double angleBetweenTwoVectors(Vector7 v1, Vector7 v2)
    {
        return Math.acos(v1.dot(v2) / (mag(v1) * mag(v2)));
    }
    public double heading()
    {
        return Math.atan2(y, x);
    }



}

