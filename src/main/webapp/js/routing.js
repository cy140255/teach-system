$(document).ready(function() {

    var regEx = /^\d{4}$/;

    function removeRouting() {
        var row = $('#routingList').datagrid('getSelected');
        if (row) {
            $.messager.confirm('Confirm', '删除该【路由】的同时，将会删除其下所有的【节点】和【动作】，确定要删吗?', function (r) {
                if (r) {
                    $.ajax({
                        type: "post",
                        url: 'remove_routing_by_id?id=' + row.routingId,
                        success: function () {
                            //showAlert("删除成功。");
                            $('#routingList').datagrid('reload');
                        },
                        error: function () {
                            show("删除失败！")
                        }
                    });
                }
            });
        } else {
            show("请选择要删除的【路由】。");
        }
    }

    var url;

    function editRouting() {
        var row = $('#routingList').datagrid('getSelected');
        if (row) {

            $.get("routingEditPart.html", function(data) {
                $("#dlg").html( data );
                $('#dlg').dialog('open').dialog('setTitle', '编辑路由');
                $('#routingEditForm').form('load', row);
                $('#nextNodeId').combobox({
                    url:'load_routingNode?id=' + row.routingId,
                    method:'post',
                    textField:'routingNodeName',
                    valueField:'nodeId',
                    required:true,
                    onLoadError:function(){
                        show('加载路由节点失败!');
                    }
                });
                url = 'update_routing?id=' + row.routingId;
            });
        }
        else {
            show("请选中要编辑的【路由】。");
        }
    }


    function saveRouting() {
        var routingName = $("#routingName").val();
        if (routingName == null || routingName.trim().length == 0) {
            show("【路由名称】不能为空。");
            return;
        }
        if (routingName.trim().length > 100) {
            show("【路由名称】长度不能超过100。");
            return;
        }

        var routingCode = $("#routingCode").val();
        if (routingCode == null) {
            show("【路由代码】不能为空。");
            return;
        }
        if (!regEx.test(routingCode)) {
            show("【路由代码】格式不正确，请输入4位数字。");
            return;
        }

        $.ajax({
            url: url,
            data: JSON.stringify(form2Json($("#routingEditForm"))),
            contentType: "application/json",
            type: "post",
            success: function () {
                $('#dlg').dialog('close');        // close the dialog
                $('#routingList').datagrid('reload');    // reload the user data
            },
            error: function () {
                show("操作失败！");
            }
        });
    }

    function addRouting() {
        $.get("routingEditPart.html", function(data) {
            $("#dlg").html( data );
            $('#dlg').dialog('open').dialog('setTitle', '新增路由');
            $('#cc').css('visibility','hidden');
            url = 'add_routing';
        });
    }

    //var routingTabMapping = {};
    var routingId;
    // 节点列表
    var nodeArray = [];
    // 模块列表
    var moduleArray = [];
    // 班级列表
    var class2Array=[];
    // 学生列表
    var studentArray = [];
    function editRoutingNode() {
        var row = $('#routingList').datagrid('getSelected');
        if (row) {
            //每次只能开一个（？？？？？）
            $('#tt').tabs('close', 2);

            $('#tt').tabs('add', {
                title: row.routingName + " | " + row.routingCode,
                closable: true,
                href: "nodePart.html"
                //id: "row_" + row.routingId
            });

            //routingTabMapping[row.routingName + " | " + row.routingCode] = row.routingId;
            routingId = row.routingId;
        }
        else {
            show("请选中要查看的【路由】。");
        }
    }


    var done = false;

    $("#tt").tabs({
        onLoad: function (title, index) {
            //$("#toolbar4tree").attr("id", "toolbar4tree" + title);
            if (!done) {
                done = true;

                $("#btnSaveNode").click(saveNode);
                $("#btnSaveAction").click(saveAction);
                $("#btnSaveClass2").click(saveClass2);
                $("#btnSaveStudent").click(saveStudent);
                $('#dlg4Node').dialog({
                    modal: true
                });

                $('#dlg4Action').dialog({
                    modal: true
                });

                $('#dlg4Class2').dialog({
                    modal: true
                });
                $('#dlg4Student').dialog({
                    modal: true
                });
            } else {
            }

            $("#btnAddNode").click(addNode);
            $("#btnAddAction").click(addAction);
            $("#btnAddStudent").click(addStudent);
            $("#btnEditNodeOrAction").click(editNodeOrAction);
            $("#btnRemoveNodeOrAction").click(removeNodeOrAction);

            $('#nodeList').treegrid({
                url: 'load_routing_nodes?id=' + routingId,
                onLoadSuccess: function(row, data) {
                    nodeArray = [];
                    $.each(data.rows, function(n, r) {
                        if (!r._parentId) {
                            var cloned = {};
                            $.extend(cloned, r);
                            nodeArray.push(cloned);

                            cloned.children = null;
                        }
                    });

                    console.log(nodeArray);
                }
            });

            $('#studentList').treegrid({
                url: 'load_class2_student?id=' + class2id,
                onLoadSuccess: function(row, data) {
                    studentArray = [];
                    $.each(data.rows, function(n, r) {
                        if (!r._parentId) {
                            var cloned = {};
                            $.extend(cloned, r);
                            studentArray.push(cloned);

                            cloned.children = null;
                        }
                    });

                    console.log(studentArray);
                }
            });
        }
    });


    function addNode() {
        $.get("nodeEditPart.html", function(data) {
            $("#dlg4Node").html( data );

            $('#dlg4Node').dialog('open').dialog('setTitle','新增节点');
            url = 'add_node?routingId=' + routingId;
        });
    }

    function editNodeOrAction() {
        var row = $('#nodeList').datagrid('getSelected');
        if (row){
            if(row._parentId) {
                $.get("actionEditPart.html", function(d) {
                    $("#dlg4Action").html(d);

                    $('#dlg4Action').dialog('open').dialog('setTitle', '编辑动作');
                    $("#actionEditForm").form('load', row);

                    $('#nextNode').combobox({
                        panelMaxHeight: 150,
                        panelMinHeight:60,
                        valueField:"nodeId",
                        textField:"routingNodeName",
                        data: nodeArray
                    });

                    $('#targetModuleId').combobox({
                        panelMaxHeight: 150,
                        panelMinHeight:60,
                        valueField:"id",
                        textField:"moduleName",
                        data: moduleArray
                    });

                    url = 'update_action?id=' + row.actionId;
                });
            }
            else {
                $.get("nodeEditPart.html", function(data) {
                    $("#dlg4Node").html(data);

                    $('#dlg4Node').dialog('open').dialog('setTitle', '编辑节点');
                    $("#nodeEditForm").form('load', row);

                    url = 'update_node?id=' + row.nodeId;
                });
            }
        }
        else {
            show("请选中要编辑的【节点】或【动作】。");
        }
    }

    function saveNode() {
        var routingNodeName = $("#routingNodeName").val();
        if (routingNodeName == null || routingNodeName.trim().length == 0) {
            show("【节点名称】不能为空。");
            return;
        }
        if (routingNodeName.trim().length > 100) {
            show("【节点名称】长度不能超过100。");
            return;
        }

        $.ajax({
            url: url,
            data: JSON.stringify(form2Json($("#nodeEditForm"))),
            contentType: "application/json",
            type: "post",
            success: function () {
                $('#dlg4Node').dialog('close');        // close the dialog

                $('#nodeList').treegrid({
                    url:'load_routing_nodes?id=' + routingId
                });
            },
            error: function () {
                show("操作失败！");
            }
        });
    }


    function addAction() {
        var row = $('#nodeList').datagrid('getSelected');
        if (row) {
            if (row._parentId) {
                show("请选中要添加【动作】的【节点】，而不是选中一个【动作】。");
            } else {
                $.get("actionEditPart.html", function (data) {
                    $("#dlg4Action").html(data);

                    $('#dlg4Action').dialog('open').dialog('setTitle', '新增动作');
                    url = 'add_action?nodeId=' + row.nodeId;

                    $('#nextNode').combobox({
                        panelMaxHeight: 150,
                        panelMinHeight:60,
                        valueField:"nodeId",
                        textField:"routingNodeName",
                        data: nodeArray
                    });

                    $('#targetModuleId').combobox({
                        panelMaxHeight: 150,
                        panelMinHeight:60,
                        valueField:"id",
                        textField:"moduleName",
                        data: moduleArray
                    });
                });
            }
        } else {
            show("请选中要添加【动作】的【节点】。");
        }
    }

    function saveAction() {
        var resultCode = $("#resultCode").val();
        if (resultCode == null) {
            show("【结果码】不能为空。");
            return;
        }
        if (!regEx.test(resultCode)) {
            show("【结果码】格式不正确，请输入4位数字。");
            return;
        }

        var clazzName = $("#clazzName").val();
        if (clazzName.trim().length > 100) {
            show("【要处理的类名】长度不能超过100。");
            return;
        }

        var methodName = $("#methodName").val();
        if (methodName.trim().length > 100) {
            show("【要调用的方法名】长度不能超过100。");
            return;
        }

        $.ajax({
            url: url,
            data: JSON.stringify(form2Json($("#actionEditForm"))),
            contentType: "application/json",
            type: "post",
            success: function () {
                $('#dlg4Action').dialog('close');        // close the dialog

                $('#nodeList').treegrid({
                    url:'load_routing_nodes?id=' + routingId
                });
            },
            error: function () {
                show("操作失败！");
            }
        });
    }

    function removeNodeOrAction() {
        var row = $('#nodeList').datagrid('getSelected');
        if (row) {
            if(row._parentId) { // action
                $.messager.confirm('Confirm', '确定要删除此【动作】吗?', function (r) {
                    if (r) {
                        $.ajax({
                            type: "post",
                            url: 'remove_action?id=' + row.actionId,
                            success: function () {
                                $('#nodeList').treegrid({
                                    url:'load_routing_nodes?id=' + routingId

                                });
                            },
                            error: function () {
                                show("删除失败！")
                            }
                        });
                    }
                });
            }
            else {  // node
                $.messager.confirm('Confirm', '删除该【节点】的同时，将会删除其下所有的【动作】，确定要删除吗?', function (r) {
                    if (r) {
                        $.ajax({
                            type: "post",
                            url: 'remove_node?nodeId=' + row.nodeId + '&routingId=' + routingId,
                            success: function () {
                                $('#nodeList').treegrid({
                                    url:'load_routing_nodes?id=' + routingId
                                });
                            },
                            error: function () {
                                show("删除失败！")
                            }
                        });
                    }
                });
            }
        }
        else {
            show("请选中要删除的【节点】或【动作】。");
        }
    }

    function addModule() {
        $.get("admin/moduleEditPart.html", function(data) {
            $("#dlg4Module").html( data );
            $('#dlg4Module').dialog('open').dialog('setTitle', '新增模块');
            url = 'add_module';
        });
    }

    function editModule() {
        openEditWindow({
            title:"编辑模块",
            row: $('#moduleList').datagrid('getSelected'),
            loadUrl: "moduleEditPart.html",
            winObj: $("#dlg4Module"),
            formID:"moduleEditForm",
            actionUrl: "update_module",
            errorMessage: "请选中要编辑的【模块】。"
        });
    }

    function removeModule() {
        var row = $('#moduleList').datagrid('getSelected');
        if (row) {
            $.messager.confirm('Confirm', '确定要删除该【模块】吗?', function (r) {
                if (r) {
                    $.ajax({
                        type: "post",
                        url: 'remove_module?id=' + row.id,
                        success: function () {
                            $('#moduleList').datagrid({
                                url:'load_modules'
                            });
                        },
                        error: function () {
                            show("删除失败！")
                        }
                    });
                }
            });
        } else {
            show("请选中要删除的【模块】。");
        }
    }

    function saveModule() {

        var moduleName = $("#moduleName").val();
        if (moduleName == null || moduleName.trim().length == 0) {
            show("【名称】不能为空。");
            return;
        }
        if (moduleName.trim().length > 100) {
            show("【名称】长度不能超过100。");
            return;
        }
        var moduleCode = $("#moduleCode").val();
        if (moduleCode == null) {
            show("【模块代码】不能为空。");
           return;
        }

        var regEx1 = /^[a-zA-Z0-9]{4}$/;
        if (!regEx1.test(moduleCode)) {
            show("【模块代码】格式不正确，输入英文或数字，长度为4。");
            return;
        }

        var exceptionCode = $("#exceptionCode").val();
        var failureCode = $("#failureCode").val();
        var timeoutCode = $("#timeoutCode").val();

        if (exceptionCode == null) {
            show("【异常码】不能为空。");
            return;
        }
        if (!regEx.test(exceptionCode)) {
            show("【异常码】格式不正确，请输入4位数字。");
            return;
        }
        if (failureCode == null) {
            show("【失败码】不能为空。");
            return;
        }
        if (!regEx.test(failureCode)) {
            show("【失败码】格式不正确，请输入4位数字。");
            return;
        }
        if (timeoutCode == null) {
            show("【超时码】不能为空。");
            return;
        }
        if (!regEx.test(timeoutCode)) {
            show("【超时码】格式不正确，请输入4位数字。");
            return;
        }

        var pattern=/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/;
        var flag_ip = $("#ip").val();
        alert(flag_ip);
        if (flag_ip == null || flag_ip.trim().length == 0) {
            show("【IP】不能为空。");
            return;
        }
        if(!pattern.test(flag_ip)){alert(flag_ip);
            show("【IP】输入非法。");
            return;
        }

        $.ajax({
            url: url,
            data: JSON.stringify(form2Json($("#moduleEditForm"))),
            contentType: "application/json",
            type: "post",
            success: function () {
                $('#dlg4Module').dialog('close');        // close the dialog

                $('#moduleList').datagrid({
                    url:'load_modules'
                });
            },
            error: function () {
                show("操作失败！");
            }
        });
    }

    function addClass2() {
        $.get("class2EditPart.html", function(data) {
            $("#dlg4Class2").html( data );
            $('#dlg4Class2').dialog('open').dialog('setTitle', '新增班级');
            url = 'add_class2';
        });
    }

    function editClass2() {
        openEditWindow({
            title:"编辑班级",
            row: $('#class2List').datagrid('getSelected'),
            loadUrl: "class2EditPart.html",
            winObj: $("#dlg4Class2"),
            formID:"class2EditForm",
            actionUrl: "update_class2",
            errorMessage: "请选中要编辑的【班级】。"
        });
    }

    function removeClass2() {
        var row = $('#class2List').datagrid('getSelected');
        if (row) {
            $.messager.confirm('Confirm', '确定要删除该【班级】吗?', function (r) {
                if (r) {
                    $.ajax({
                        type: "post",
                        url: 'remove_class2?id=' + row.id,
                        success: function () {
                            $('#class2List').datagrid({
                                url:'load_class2s'
                            });
                        },
                        error: function () {
                            show("删除失败！")
                        }
                    });
                }
            });
        } else {
            show("请选中要删除的【模块】。");
        }
    }

    function saveClass2() {

        var class2Num = $("#class2Num").val();
        if (class2Num == null || class2Num.trim().length == 0) {
            show("【编号】不能为空。");
            return;
        }
        if (class2Num.trim().length > 4) {
            show("【编号】长度不能超过4。");
            return;
        }
        $.ajax({
            url: url,
            data: JSON.stringify(form2Json($("#class2EditForm"))),
            contentType: "application/json",
            type: "post",
            success: function () {
                $('#dlg4Class2').dialog('close');        // close the dialog

                $('#class2List').datagrid({
                    url:'load_class2s'
                });
            },
            error: function () {
                show("操作失败！");
            }
        });
    }

    function editClass2Student() {
        var row = $('#class2List').datagrid('getSelected');
        if (row) {
            //每次只能开一个（？？？？？）
            $('#tt').tabs('close', 2);

            $('#tt').tabs('add', {
                title: "编号："+row.class2Num,
                closable: true,
                href: "studentPart.html"
                //id: "row_" + row.routingId
            });
            //routingTabMapping[row.routingName + " | " + row.routingCode] = row.routingId;
           class2id = row.id;
        }
        else {
            show("请选中要查看的【班级】。");
        }
    }

    function addStudent() {
        $.get("studentEditPart.html", function(data) {
            $("#dlg4Student").html( data );
            $('#dlg4Student').dialog('open').dialog('setTitle', '新增学生');
            url = 'add_student';

            $('#class2Num').combobox({
                panelMaxHeight: 150,
                panelMinHeight:60,
                valueField:"id",
                textField:"class2Num",
                data: class2Array
            });
        });
    }

    function editStudent() {
        openEditWindow({
            title:"编辑学生",
            row: $('#studentList').datagrid('getSelected'),
            loadUrl: "studentEditPart.html",
            winObj: $("#dlg4Student"),
            formID:"studentEditForm",
            actionUrl: "update_student",
            errorMessage: "请选中要编辑的【学生】。"
        });
    }

    function removeStudent() {
        var row = $('#studentList').datagrid('getSelected');
        if (row) {
            $.messager.confirm('Confirm', '确定要删除该【学生】吗?', function (r) {
                if (r) {
                    $.ajax({
                        type: "post",
                        url: 'remove_student?id=' + row.id,
                        success: function () {
                            $('#studentList').datagrid({
                                url:'load_students'
                            });
                        },
                        error: function () {
                            show("删除失败！")
                        }
                    });
                }
            });
        } else {
            show("请选中要删除的【学生】。");
        }
    }

    function saveStudent() {

        var studentName = $("#studentName").val();
        if (studentName == null || studentName.trim().length == 0) {
            show("【姓名】不能为空。");
            return;
        }
        if (studentName.trim().length > 5) {
            show("【姓名】长度不能超过5。");
            return;
        }
        $.ajax({
            url: url,
            data: JSON.stringify(form2Json($("#studentEditForm"))),
            contentType: "application/json",
            type: "post",
            success: function () {
                $('#dlg4Student').dialog('close');        // close the dialog

                $('#studentList').datagrid({
                    url:'load_students'
                });
            },
            error: function () {
                show("操作失败！");
            }
        });
    }

    function openEditWindow(obj) {
        //show(JSON.stringify(obj.row));
        if (obj.row) {

            $.get(obj.loadUrl, function(data) {
                obj.winObj.html( data );
                obj.winObj.dialog('open').dialog('setTitle', obj.title);
                $("#" + obj.formID).form('load', obj.row);
                url = obj.actionUrl;
            });
        }
        else {
            show(obj.errorMessage);
        }
    }

    function init() {

        $("#btnAddRouting").click(addRouting);
        $("#btnEditRouting").click(editRouting);
        $("#btnEditRoutingNode").click(editRoutingNode);
        $("#btnRemoveRouting").click(removeRouting);
        $("#btnSaveRouting").click(saveRouting);

        $("#btnAddModule").click(addModule);
        $("#btnEditModule").click(editModule);
        $("#btnRemoveModule").click(removeModule);
        $("#btnSaveModule").click(saveModule);

        $("#btnAddClass2").click(addClass2);
        $("#btnEditClass2").click(editClass2);
        $("#btnRemoveClass2").click(removeClass2);
        $("#btnSaveClass2").click(saveClass2);
        $("#btnEditClass2Student").click(editClass2Student);

        $("#btnAddStudent").click(addStudent);
        $("#btnEditStudent").click(editStudent);
        $("#btnRemoveStudent").click(removeStudent);
        $("#btnSaveStudent").click(saveStudent);
        // 初始化部分组件
        $('#dlg').dialog( {
            modal: true
        });

        $('#dlg4Module').dialog( {
            modal: true
        });

        $('#dlg4Class2').dialog( {
            modal: true
        });

        $('#dlg4Student').dialog( {
            modal: true
        });

        $('#class2List').datagrid({
            url:'load_class2s',
            method: 'get',
            onLoadSuccess: function(data) {
                console.log(JSON.stringify(data));
                $.extend(class2Array, data.rows);

            }
        });

        $('#moduleList').datagrid({
            url:'load_modules',
            method: 'get',
            onLoadSuccess: function(data) {
                console.log(JSON.stringify(data));
                $.extend(moduleArray, data.rows);

            }
        });

        //show("1");
    }

    init();
});