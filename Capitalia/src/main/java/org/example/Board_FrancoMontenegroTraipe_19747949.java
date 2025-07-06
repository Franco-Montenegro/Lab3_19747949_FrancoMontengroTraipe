package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board_FrancoMontenegroTraipe_19747949 {
    private List<Property_FrancoMontenegroTraipe_19747949> propiedades;
    private List<CardComunidad_FrancoMontenegroTraipe_19747949> cartasComunidad;
    private List<CardSuerte_FrancoMontenegroTraipe_19747949> cartasSuerte;
    private int posicionSalida;
    private int posicionCarcel;
    private int posicionComunidad;
    private int posicionSuerte;

    public Board_FrancoMontenegroTraipe_19747949() {
        this.propiedades = new ArrayList<Property_FrancoMontenegroTraipe_19747949>();
        this.cartasComunidad = new ArrayList<CardComunidad_FrancoMontenegroTraipe_19747949>();
        this.cartasSuerte = new ArrayList<CardSuerte_FrancoMontenegroTraipe_19747949>();
        this.posicionSalida = 0;
        this.posicionCarcel = 10;
        this.posicionComunidad = 5;
        this.posicionSuerte = 15;
        cargarDatosIniciales();
    }

    public void agregarPropiedad(Property_FrancoMontenegroTraipe_19747949 propiedad) {
        propiedades.add(propiedad);
    }

    public void agregarCartaComunidad(CardComunidad_FrancoMontenegroTraipe_19747949 carta) {
        cartasComunidad.add(carta);
    }

    public void agregarCartaSuerte(CardSuerte_FrancoMontenegroTraipe_19747949 carta) {
        cartasSuerte.add(carta);
    }

    public boolean esCasillaSalida(int posicion) {
        return posicion == 0;
    }

    public boolean esCarcel(int posicion) {
        return posicion == posicionCarcel;
    }

    public boolean esComunidad(int posicion) {
        return posicion == posicionComunidad;
    }

    public boolean esSuerte(int posicion) {
        return posicion == posicionSuerte;
    }
    public int getPosicionComunidad() {
        return posicionComunidad;
    }

    public int getPosicionSuerte() {
        return posicionSuerte;
    }

    public Property_FrancoMontenegroTraipe_19747949 getPropiedadEn(int posicion) {
        for (Property_FrancoMontenegroTraipe_19747949 p : propiedades) {
            if (p.getId() == posicion) return p;
        }
        return null;
    }
    public void reemplazarPropiedad(Property_FrancoMontenegroTraipe_19747949 nuevaPropiedad) {
        for (int i = 0; i < propiedades.size(); i++) {
            if (propiedades.get(i).getId() == nuevaPropiedad.getId()) {
                propiedades.set(i, nuevaPropiedad);
                return;
            }
        }
    }

    public CardComunidad_FrancoMontenegroTraipe_19747949 obtenerCartaComunidadAleatoria() {
        if (cartasComunidad == null || cartasComunidad.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(cartasComunidad.size());
        return cartasComunidad.get(index);
    }

    public CardSuerte_FrancoMontenegroTraipe_19747949 obtenerCartaSuerteAleatoria() {
        if (cartasSuerte == null || cartasSuerte.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(cartasSuerte.size());
        return cartasSuerte.get(index);
    }


    public List<Property_FrancoMontenegroTraipe_19747949> getPropiedades() {
        return propiedades;
    }
    public List<CardComunidad_FrancoMontenegroTraipe_19747949> getCartasComunidad() {
        return cartasComunidad;
    }
    public List<CardSuerte_FrancoMontenegroTraipe_19747949> getCartasSuerte() {
        return cartasSuerte;
    }
    public int getPosicionCarcel() {
        return posicionCarcel;
    }

    public int getTotalCasillas() {
        int maxPos = 0;

        for (Property_FrancoMontenegroTraipe_19747949 p : propiedades) {
            if (p.getId() > maxPos) {
                maxPos = p.getId();
            }
        }

        maxPos = Math.max(maxPos, posicionCarcel);
        maxPos = Math.max(maxPos, posicionComunidad);
        maxPos = Math.max(maxPos, posicionSuerte);

        return maxPos + 1;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== TABLERO CAPITALIA ===\n");

        sb.append("\nPropiedades:\n");
        for (Property_FrancoMontenegroTraipe_19747949 prop : propiedades) {
            sb.append(prop).append("\n");
        }

        sb.append("\nCartas de Comunidad:\n");
        for (Card_FrancoMontenegroTraipe_19747949 carta : cartasComunidad) {
            sb.append(carta).append("\n");
        }

        sb.append("\nCartas de Suerte:\n");
        for (Card_FrancoMontenegroTraipe_19747949 carta : cartasSuerte) {
            sb.append(carta).append("\n");
        }

        sb.append("\nPosiciones especiales:\n");
        sb.append("Posición de la Cárcel: ").append(posicionCarcel).append("\n");
        sb.append("Casillas de Comunidad: ").append(posicionComunidad).append("\n");
        sb.append("Casillas de Suerte: ").append(posicionSuerte).append("\n");

        return sb.toString();
    }
    public void cargarDatosIniciales() {
        posicionSalida = 0;
        posicionSuerte = 5;
        posicionComunidad = 15;
        posicionCarcel = 10;
        propiedades = new ArrayList<>();

        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(1, "Pallet Town", 60, 20, null, 0, false));
        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(2, "Viridian Forest", 60, 25, null, 0, false));
        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(3, "Pewter City", 100, 30, null, 0, false));
        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(4, "Mt. Moon", 120, 35, null, 0, false));

        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(6, "Cerulean City", 140, 40, null, 0, false));
        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(7, "Vermilion City", 160, 45, null, 0, false));
        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(8, "Celadon City", 180, 50, null, 0, false));
        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(9, "Saffron City", 200, 55, null, 0, false));

        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(11, "Lavander Town", 220, 60, null, 0, false));
        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(12, "Fuchsia City", 280, 70, null, 0, false));
        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(13, "Cinnabar Island", 320, 80, null, 0, false));
        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(14, "Victory Road", 340, 85, null, 0, false));

        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(16, "Indigo Plateau", 400, 90, null, 0, false));
        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(17, "Unkown Dungeon", 400, 95, null, 0, false));
        agregarPropiedad(new Property_FrancoMontenegroTraipe_19747949(18, "Pokémon League", 450, 100, null, 0, false));

        cartasSuerte = new ArrayList<>();
        agregarCartaSuerte(new CardSuerte_FrancoMontenegroTraipe_19747949(1, "Un Meowth salvaje usó Día de Pago. ¡Recibes $200!"));
        agregarCartaSuerte(new CardSuerte_FrancoMontenegroTraipe_19747949(2, "Capturaste un Weedle en el Bosque Verde. Véndelo por $200."));
        agregarCartaSuerte(new CardSuerte_FrancoMontenegroTraipe_19747949(3, "El Team Rocket te ha robado $100 mientras dormías..."));
        agregarCartaSuerte(new CardSuerte_FrancoMontenegroTraipe_19747949(4, "Encuentras un Fósil raro en el Mt. Moon. Lo vendes por $200."));
        agregarCartaSuerte(new CardSuerte_FrancoMontenegroTraipe_19747949(5, "Tu Bicicleta de Ciudad Azulona fue robada. Pierdes $100."));
        agregarCartaSuerte(new CardSuerte_FrancoMontenegroTraipe_19747949(6, "¡Tu Pokémon aprendió Surf! Avanzas 5 casillas."));
        agregarCartaSuerte(new CardSuerte_FrancoMontenegroTraipe_19747949(7, "Te perdiste en la Cueva Diglett. Retrocedes 3 casillas."));
        agregarCartaSuerte(new CardSuerte_FrancoMontenegroTraipe_19747949(8, "Un policía de Ciudad Celeste te confundió con un ladrón. ¡Vas a la cárcel!"));
        agregarCartaSuerte(new CardSuerte_FrancoMontenegroTraipe_19747949(9, "Tus Pokémon ganan un torneo de aficionados en Pueblo Lavanda. Recibes 200"));
        agregarCartaSuerte(new CardSuerte_FrancoMontenegroTraipe_19747949(10, "Usas Cuerda Huida y huyes de un centro de detención. Ve al inicio"));

        cartasComunidad = new ArrayList<>();
        agregarCartaComunidad(new CardComunidad_FrancoMontenegroTraipe_19747949(1, "El Profesor Oak te otorga una beca de investigación. Recibes 200"));
        agregarCartaComunidad(new CardComunidad_FrancoMontenegroTraipe_19747949(2, "Te ofreciste como voluntario en el Centro Pokémon. Recibes 200"));
        agregarCartaComunidad(new CardComunidad_FrancoMontenegroTraipe_19747949(3, "Has causado un apagón al usar demasiados ataques eléctricos. Pierdes $100"));
        agregarCartaComunidad(new CardComunidad_FrancoMontenegroTraipe_19747949(4, "Fuiste mordido por un Ekans. Pierdes $100 en gastos médicos ."));
        agregarCartaComunidad(new CardComunidad_FrancoMontenegroTraipe_19747949(5, "Tu Charmander quemó parte de tu casa. Pierdes $100"));
        agregarCartaComunidad(new CardComunidad_FrancoMontenegroTraipe_19747949(6, "Tu rival Gary te humilla en combate. Paga 100 por entrenamiento."));
        agregarCartaComunidad(new CardComunidad_FrancoMontenegroTraipe_19747949(7, "Encuentras una Pokémoneda antigua entre tus cosas. Recibes 200."));
        agregarCartaComunidad(new CardComunidad_FrancoMontenegroTraipe_19747949(8, "Tu madre te envía dinero desde Pueblo Paleta. Recibes 200."));
        agregarCartaComunidad(new CardComunidad_FrancoMontenegroTraipe_19747949(9, "Tu Snorlax bloqueó una ruta. Multa de tránsito $100."));
        agregarCartaComunidad(new CardComunidad_FrancoMontenegroTraipe_19747949(10, "Usas una MT especial que te permite evitar problemas legales. Ve al inicio."));
    }

}
