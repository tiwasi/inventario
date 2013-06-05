/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
    $(".remoto").click(function(event) {
        event.preventDefault();
        cargarVistaEnContenedor($(this).attr("href"));
    });
});
function cargarVistaEnContenedor(url) {
    $("#contenedor").html($("#loading").html());
    $("#contenedor").load(url);
}