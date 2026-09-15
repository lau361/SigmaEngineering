package Dominio;

import Crosscuting.Utilitario.UtilId;
import Crosscuting.Utilitario.UtilObjeto;

import java.math.BigDecimal;
import java.util.UUID;

public class InventarioDominio {

    private UUID id;
    private BigDecimal cantidadTotal;
    private ProductoInternoDominio productoInterno;
    private UnidadMedidaDominio unidadMedidaInventario;
    private BigDecimal stockMinimo;
    private PizzeriaDominio pizzeria;

    private InventarioDominio(Builder builder) {
        this.id = builder.id;
        this.cantidadTotal = builder.cantidadTotal;
        this.productoInterno = builder.productoInterno;
        this.unidadMedidaInventario = builder.unidadMedidaInventario;
        this.stockMinimo = builder.stockMinimo;
        this.pizzeria = builder.pizzeria;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getCantidadTotal() {
        return cantidadTotal;
    }

    public ProductoInternoDominio getProductoInterno() {
        return productoInterno;
    }

    public UnidadMedidaDominio getUnidadMedidaInventario() {
        return unidadMedidaInventario;
    }

    public BigDecimal getStockMinimo() {
        return stockMinimo;
    }

    public PizzeriaDominio getPizzeria() {
        return pizzeria;
    }

    public static class Builder {

        private UUID id;
        private BigDecimal cantidadTotal;
        private ProductoInternoDominio productoInterno;
        private UnidadMedidaDominio unidadMedidaInventario;
        private BigDecimal stockMinimo;
        private PizzeriaDominio pizzeria;

        public Builder() {
            id = UtilId.valorDefecto(id);
            cantidadTotal = BigDecimal.ZERO;
            productoInterno =
                    new ProductoInternoDominio.Builder().build();
            unidadMedidaInventario =
                    new UnidadMedidaDominio.Builder().build();
            stockMinimo = BigDecimal.ZERO;
            pizzeria =
                    new PizzeriaDominio.Builder().build();
        }

        public Builder id(UUID id) {
            this.id = UtilId.valorDefecto(id);
            return this;
        }

        public Builder cantidadTotal(BigDecimal cantidadTotal) {
            this.cantidadTotal = UtilObjeto
                    .obtenerValorDefectoSiValorOriginalEsNulo(
                            cantidadTotal,
                            BigDecimal.ZERO
                    );
            return this;
        }

        public Builder productoInterno(
                ProductoInternoDominio productoInterno) {

            this.productoInterno = UtilObjeto
                    .obtenerValorDefectoSiValorOriginalEsNulo(
                            productoInterno,
                            new ProductoInternoDominio.Builder().build()
                    );
            return this;
        }

        public Builder unidadMedidaInventario(
                UnidadMedidaDominio unidadMedidaInventario) {

            this.unidadMedidaInventario = UtilObjeto
                    .obtenerValorDefectoSiValorOriginalEsNulo(
                            unidadMedidaInventario,
                            new UnidadMedidaDominio.Builder().build()
                    );
            return this;
        }

        public Builder stockMinimo(BigDecimal stockMinimo) {
            this.stockMinimo = UtilObjeto
                    .obtenerValorDefectoSiValorOriginalEsNulo(
                            stockMinimo,
                            BigDecimal.ZERO
                    );
            return this;
        }

        public Builder pizzeria(PizzeriaDominio pizzeria) {
            this.pizzeria = UtilObjeto
                    .obtenerValorDefectoSiValorOriginalEsNulo(
                            pizzeria,
                            new PizzeriaDominio.Builder().build()
                    );
            return this;
        }

        public InventarioDominio build() {
            return new InventarioDominio(this);
        }
    }
}