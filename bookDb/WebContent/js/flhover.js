
    $(document).ready(function(){

        
        $('nav ul li:nth-of-type(1)').hover(function(){
            $('#fl').css('display','block');
            $('#box').css('position','relative');
            $('#fl').css('position','absolute');
            $('#fl').css('top','-20px');
            
        },function(){
            $('#fl').css('display','none');
        }
        )
    
        $('#fl').hover(function(){
            $('nav ul li:nth-of-type(1)').css('background-color','#c6a58a')
            $('#fl').css('display','block');
            $('#box').css('position','relative');
            $('#fl').css('position','absolute');
            $('#fl').css('top','-20px');
            
        },function(){
            $('nav ul li:nth-of-type(1)').css('background-color','white')
            $('#fl').css('display','none');
        })
        
        })