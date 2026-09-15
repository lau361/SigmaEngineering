package Dominio;

import Crosscuting.Utilitario.UtilId;
import Crosscuting.Utilitario.UtilObjeto;
import Crosscuting.Utilitario.UtilTexto;

import java.util.UUID;

public class UbicacionDominio {

    private UUID id;
    private String direccion;
    private BarrioDominio barrio;

    private UbicacionDominio(Builder builder) {
        this.id = builder.id;
        this.direccion = builder.direccion;
        this.barrio = builder.barrio;
    }

    public UUID getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public BarrioDominio getBarrio() {
        return barrio;
    }

    public static class Builder {

        private UUID id;
        private String direccion;
        private BarrioDominio barrio;

        public Builder() {
            id = UtilId.valorDefecto(id);
            direccion = UtilTexto.vacia;
            barrio = new BarrioDominio.Builder().build();
        }

        public Builder id(UUID id) {
            this.id = UtilId.valorDefecto(id);
            return this;
        }

        public Builder direccion(String direccion) {
            this.direccion = UtilTexto.getUtilTexto()
                    .quitarEspaciosEnBlanco(direccion);
            return this;
        }

        public Builder barrio(BarrioDominio barrio) {
            this.barrio = UtilObjeto
                    .obtenerValorDefectoSiValorOriginalEsNulo(
                            barrio,
                            new BarrioDominio.Builder().build()
                    );
            return this;
        }

        public UbicacionDominio build() {
            return new UbicacionDominio(this);
        }
    }
}