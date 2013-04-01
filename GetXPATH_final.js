javascript:function GetXPATH_final()
{
var currentNode=document.selection.createRange().parentElement();
var path=[];
while(currentNode)
{
var pe=getNode(currentNode);
if(pe)
{
path.push(pe);
if(pe.indexOf('@id')!=-1)break;
}
currentNode=currentNode.parentNode;
}
var xpath="/"+path.reverse().join('/');
clipboardData.setData("Text", xpath);
}
GetXPATH_final();
