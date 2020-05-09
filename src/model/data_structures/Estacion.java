package model.data_structures;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Estacion  {


    public int OBJECTID;
    public int PLAN;
    public int CODENT;
    public int COD_PROY;
    public int ANIO_GEO;
    public String FECHA_INI;
    public String FECHA_FIN;
    public String DESCRIPCION;
    public String EST_PROY;
    public String INTERV_ESP;
    public String DIR_SITIO;
    public String COD_SITIO;
    public int latitud;
    public int longitud;
    public String SERVICIO;
    public String HORARIO;
    public int TELEFONO;
    public String CELEC;
    public String CONTACTO;
    public String PAG_WEB;
    public int IUU_PLAN;
    public int IUSCATA;
    public int IULOCAL;
    public String EASOCIA;
    public String FUNCION;
    public String TEQUIPA;
    public String NOMBRE;
    public String IDENTIFICACION;
    public int FECHA_C;


    public Estacion(int OBJECTID,   int PLAN, int CODENT, int COD_PROY, int ANIO_GEO, String FECHA_INI, String FECHA_FIN, String DESCRIPCION, String EST_PROY,
                                String INTERV_ESP, String DIR_SITIO, String COD_SITIO, int latitud, int longitud, String SERVICIO, String HORARIO, int TELEFONO,
                                String CELEC, String CONTACTO, String PAG_WEB, int IUU_PLAN, int IUSCATA, int IULOCAL, String EASOCIA, String FUNCION, String TEQUIPA,
                                String NOMBRE, String IDENTIFICACION, int FECHA_C){

        this.OBJECTID = OBJECTID;
        this.PLAN = PLAN;
        this.CODENT = CODENT;
        this.COD_PROY = COD_PROY;
        this.ANIO_GEO = ANIO_GEO;
        this.FECHA_INI = FECHA_INI;
        this.FECHA_FIN = FECHA_FIN;
        this.DESCRIPCION = DESCRIPCION;
        this.EST_PROY = EST_PROY;
        this.INTERV_ESP = INTERV_ESP;
        this.DIR_SITIO = DIR_SITIO;
        this.COD_SITIO = COD_SITIO;
        this.latitud = latitud;
        this.longitud = longitud;
        this.SERVICIO = SERVICIO;
        this.HORARIO = HORARIO;
        this.TELEFONO = TELEFONO;
        this.CELEC = CELEC;
        this.CONTACTO = CONTACTO;
        this.PAG_WEB = PAG_WEB;
        this.IUU_PLAN = IUU_PLAN;
        this.IUSCATA = IUSCATA;
        this.IULOCAL = IULOCAL;
        this.EASOCIA = EASOCIA;
        this.FUNCION = FUNCION;
        this.TEQUIPA = TEQUIPA;
        this.NOMBRE = NOMBRE;
        this.IDENTIFICACION = IDENTIFICACION;
        this.FECHA_C = FECHA_C;

    }

    public int getOBJECTID() {
        return OBJECTID;
    }

    public int getPLAN() {
        return PLAN;
    }

    public int getCODENT() {
        return CODENT;
    }

    public int getCOD_PROY() {
        return COD_PROY;
    }

    public int getANIO_GEO() {
        return ANIO_GEO;
    }

    public String getFECHA_INI() {
        return FECHA_INI;
    }

    public String getFECHA_FIN() {
        return FECHA_FIN;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public String getEST_PROY() {
        return EST_PROY;
    }

    public String getINTERV_ESP() {
        return INTERV_ESP;
    }

    public String getDIR_SITIO() {
        return DIR_SITIO;
    }

    public String getCOD_SITIO() {
        return COD_SITIO;
    }

    public int getLatitud() {
        return latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public String getSERVICIO() {
        return SERVICIO;
    }

    public String getHORARIO() {
        return HORARIO;
    }

    public int getTELEFONO() {
        return TELEFONO;
    }

    public String getCELEC() {
        return CELEC;
    }

    public String getCONTACTO() {
        return CONTACTO;
    }

    public String getPAG_WEB() {
        return PAG_WEB;
    }

    public int getIUU_PLAN() {
        return IUU_PLAN;
    }

    public int getIUSCATA() {
        return IUSCATA;
    }

    public int getIULOCAL() {
        return IULOCAL;
    }

    public String getEASOCIA() {
        return EASOCIA;
    }

    public String getFUNCION() {
        return FUNCION;
    }

    public String getTEQUIPA() {
        return TEQUIPA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getIDENTIFICACION() {
        return IDENTIFICACION;
    }

    public int getFECHA_C() {
        return FECHA_C;
    }
}