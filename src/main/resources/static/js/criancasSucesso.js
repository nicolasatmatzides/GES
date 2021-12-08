$(()=> {
    $('select').change(()=>{
        url = '/crianca/sucesso'
        const name = $('#name').val();
        const cidade = $('#cidade').val();

        if (estado !== '' || cidade !== '') {
            url += '?'
        }

        if (estado !== '') {
            url += `uf=${estado}`;
        }

        if (cidade !== '') {
            url += `&cidade=${cidade}`;
        }

        window.location.replace(url);
    })
})