const btn = document.querySelector('#btn');

btn.addEventListener('click',function(event){
    const row = parseInt(document.querySelector('#rowInput').value);
    const col = parseInt(document.querySelector('#colInput').value);
    const fild = document.querySelector('.table-div');

   let str = '<table>';
    for(let c = 0; c < row ; c++){

        str += '<tr>';

        for(let i = 0; i < col; i++){
            str += '<td>'+(c+1)+'행'+(i+1)+'열 </td>';
        }

        str += '</tr>';

    }
    str += '</table>'
    fild.innerHTML = '';

    fild.insertAdjacentHTML("afterbegin" , str);


});