;(function(){
  function a() {
    var t = document.getElementById('time');
    t.innerHTML = t.innerHTML - 1;
    if(Number(t.innerHTML)>0){
      setTimeout(a,1000);
    }
  }
  setTimeout(a,1000);
})();
