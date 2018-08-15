/**
 * 支持zTree的搜索功能
 * @param zTree 传入ztree对象
 * @param searchKey 搜索关键字，不区分大小写
 * @param searchFields 搜索那些字段，以逗号区隔
 * @param expandAll 不传值则默认不打开
 */
function doZtreeSearch(zTree, searchKey, searchFields, expandAll)
{
    //隐藏的先显示出来
    var hiddenNodes = zTree.getNodesByParam("isHidden", true);
    if (hiddenNodes)
    {
        zTree.showNodes(hiddenNodes);
    }
    //获取关键字
    if (!searchKey || searchKey == "")
    {
        return;
    }
    //过滤
    var nodes = zTree.getNodesByFilter(function (node)
    {
        var names = searchFields.split(",");
        for (var i = 0; names && i < names.length; i++)
        {
            if (node.isParent || node[names[i]].toString().replace(/(^\s*)|(\s*$)/g,'').toUpperCase().indexOf(searchKey.toString().toUpperCase()) > -1)
                return false;
        }
        return true;
    });
    zTree.hideNodes(nodes); //hide child node
    //没有父节点的也隐藏起来
    var noChildParentNodes = zTree.getNodesByFilter(function (node)
    {
        if (node.isParent && (!node.children || node.children.length == 0 || node.children.length == zTree.getNodesByParam("isHidden", true, node).length))
        {
            return true;
        }
        return false;
    });
    zTree.hideNodes(noChildParentNodes); //hide no child parent node
    expandAll = expandAll || false;
    zTree.expandAll(expandAll);
}