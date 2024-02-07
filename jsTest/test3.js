function checkAllMenu(){
    const cks = document.querySelector('#chk_all');
    const menus = document.querySelectorAll('.menu'); // input : 1,2,3
    if(cks.checked){

        for(const e of menus){
            e.checked = true;

        }

    }
    else{

        for(const e of menus){
            e.checked = false;

        }

    }
    for(const a of menus){
        checkAllOption(a);

    }
    
}
function checkAllOption(a){
    
    const lis = a.nextElementSibling.querySelectorAll('li > input');
    
    if(a.checked){
        for(const e of lis){

            e.checked = true;

        }
    }
    else{
        for(const e of lis){

            e.checked = false;

        }
    }
    

}