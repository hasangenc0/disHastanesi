/*
 * @author hasan genc
 */

(function () {
    console.log("Dis Hekimi Yazılımı");
})();

$('.datepicker').datepicker({
    format: 'dd.mm.yyyy',
    startDate: '+3d',
    language: 'tr',
    autoclose: true
});

$('.datepicker').datepicker('setDate', new Date());

// Admin Panel
