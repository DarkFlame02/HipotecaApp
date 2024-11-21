package dad.hipoteca.model;

import dad.hipoteca.api.Cuota;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Cuotas {

    private final IntegerProperty numCuota = new SimpleIntegerProperty();
    private final IntegerProperty anyoCuota = new SimpleIntegerProperty();
    private final IntegerProperty mesCuota = new SimpleIntegerProperty();
    private final DoubleProperty capitalInicial = new SimpleDoubleProperty();
    private final DoubleProperty intereses = new SimpleDoubleProperty();
    private final DoubleProperty capitalAmortizado = new SimpleDoubleProperty();
    private final DoubleProperty cuotas = new SimpleDoubleProperty();
    private final DoubleProperty capitalPendiente = new SimpleDoubleProperty();

    public Cuotas() {}

    public Cuotas(Cuota cuota) {
        numCuota.set(cuota.getNumero());
        anyoCuota.set(cuota.getAnyo());
        mesCuota.set(cuota.getMes());
        capitalInicial.set(cuota.getCapitalInicial());
        intereses.set(cuota.getIntereses());
        capitalAmortizado.set(cuota.getCapitalAmortizado());
        cuotas.set(cuota.getCuota());
        capitalPendiente.set(cuota.getCapitalPendiente());
    }

    public int getNumCuota() {
        return numCuota.get();
    }

    public IntegerProperty numCuotaProperty() {
        return numCuota;
    }

    public void setNumCuota(int numCuota) {
        this.numCuota.set(numCuota);
    }

    public int getAnyoCuota() {
        return anyoCuota.get();
    }

    public IntegerProperty anyoCuotaProperty() {
        return anyoCuota;
    }

    public void setAnyoCuota(int anyoCuota) {
        this.anyoCuota.set(anyoCuota);
    }

    public int getMesCuota() {
        return mesCuota.get();
    }

    public IntegerProperty mesCuotaProperty() {
        return mesCuota;
    }

    public void setMesCuota(int mesCuota) {
        this.mesCuota.set(mesCuota);
    }

    public double getCapitalInicial() {
        return capitalInicial.get();
    }

    public DoubleProperty capitalInicialProperty() {
        return capitalInicial;
    }

    public void setCapitalInicial(double capitalInicial) {
        this.capitalInicial.set(capitalInicial);
    }

    public double getIntereses() {
        return intereses.get();
    }

    public DoubleProperty interesesProperty() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses.set(intereses);
    }

    public double getCapitalAmortizado() {
        return capitalAmortizado.get();
    }

    public DoubleProperty capitalAmortizadoProperty() {
        return capitalAmortizado;
    }

    public void setCapitalAmortizado(double capitalAmortizado) {
        this.capitalAmortizado.set(capitalAmortizado);
    }

    public double getCuotas() {
        return cuotas.get();
    }

    public DoubleProperty cuotasProperty() {
        return cuotas;
    }

    public void setCuotas(double cuotas) {
        this.cuotas.set(cuotas);
    }

    public double getCapitalPendiente() {
        return capitalPendiente.get();
    }

    public DoubleProperty capitalPendienteProperty() {
        return capitalPendiente;
    }

    public void setCapitalPendiente(double capitalPendiente) {
        this.capitalPendiente.set(capitalPendiente);
    }

}
