/* Save this file content as a bookmark in Internet Explorer
This script helps to get the XPath of an element in IE-similar to Firefox's firebug/firepath
Select any element in a webpage and click on the two bookmarks GetXPATH_init.js,GetXPATH_final.js in the respective order to get the XPath of that element.
*/

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
