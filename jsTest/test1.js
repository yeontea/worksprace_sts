function setAvgAge(){
    const age = document.querySelectorAll('.ageTd');
    let sum = 0;

    for(let i = 0; i < age.length; i++){

          sum = sum + parseInt(age[i].textContent);
           
        

    }
    const result = document.querySelector('#resultTd');
    result.textContent = sum / age.length ;


}