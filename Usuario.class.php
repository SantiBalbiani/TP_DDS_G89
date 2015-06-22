<?php


/**
 * 
 */
class Usuario {

    /**
     * 
     */
    public function __construct() {
    }

    /**
     * @var void
     */
    public $sexo;

    /**
     * @var void
     */
    public $fecha_nacimiento;

    /**
     * @var void
     */
    public $altura;

    /**
     * @var void
     */
    public $complexion;

    /**
     * @var void
     */
    public $preferenciasAlimenticias;

    /**
     * @var void
     */
    public $condicionesPreexistentes;

    /**
     * @var void
     */
    public $dieta;

    /**
     * @var void
     */
    public $rutina;

    /**
     * @var void
     */
    public $Attribute1;

    /**
     * @param void $nombreReceta 
     * @return unaReceta
     */
    public function consultar_receta($nombreReceta) {
        // TODO implement here
        return null;
    }

    /**
     * @param void $unaReceta 
     * @return bool
     */
    public function confirmar_receta($unaReceta) {
        // TODO implement here
        return null;
    }

    /**
     * @param void $unaReceta 
     * @return bool
     */
    public function modificar_receta($unaReceta) {
        // TODO implement here
        return null;
    }

    /**
     * @param void $unaReceta 
     * @return bool
     */
    public function crear_receta($unaReceta) {
        // TODO implement here
        return null;
    }

    /**
     * @param void $otroUsuario unaReceta 
     * @return bool
     */
    public function compartir_receta($otroUsuario unaReceta) {
        // TODO implement here
        return null;
    }

    /**
     * @return bool
     */
    public function crear_grupo() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public function solicitar_reporte() {
        // TODO implement here
    }

    /**
     * @param void $unaReceta
     */
    public function calificar($unaReceta) {
        // TODO implement here
    }

}
