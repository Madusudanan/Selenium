javascript:function o__o()
{
var currentNode=document.selection.createRange().parentElement();var path=[];while(currentNode){var pe=getNode(currentNode);if(pe){path.push(pe);if(pe.indexOf('@id')!=-1)break;}currentNode=currentNode.parentNode;}var xpath="/"+path.reverse().join('/');clipboardData.setData("Text", xpath);}o__o();
