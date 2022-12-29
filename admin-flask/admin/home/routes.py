# -*- encoding: utf-8 -*-

from admin.home import blueprint
from flask import render_template, request
from flask_login import login_required
from jinja2 import TemplateNotFound


@blueprint.route("/index")
@login_required
def index():
    data = {
        "index1": {"title": "指标1", "value": 150},
        "index2": {"title": "指标2", "value": 53},
        "index3": {"title": "指标3", "value": 44},
        "index4": {"title": "指标4", "value": 65}
    }
    return render_template("home/index.html", segment="index", data=data)


@blueprint.route("/table")
@login_required
def table():
    data = [
        {"id": 1, "name": "张三", "age": 18},
        {"id": 2, "name": "李四", "age": 28},
        {"id": 3, "name": "王五", "age": 38},
    ]

    try:
        segment = get_segment(request)
        return render_template("home/table.html", segment=segment, data=data)

    except TemplateNotFound:
        return render_template("home/page-404.html"), 404

    except:
        return render_template("home/page-500.html"), 500


@blueprint.route("/chart")
@login_required
def chart():
    data = {
        "pic1": {
            "label": ['JUN', 'JUL', 'AUG', 'SEP', 'OCT', 'NOV', 'DEC'],
            "value1": [1000, 2000, 3000, 2500, 2700, 2500, 3000],
            "value2": [700, 1700, 2700, 2000, 1800, 1500, 2000]
        },
        "pic2": {
            "label": ['18th', '20th', '22nd', '24th', '26th', '28th', '30th'],
            "value1": [100, 120, 170, 167, 180, 177, 160],
            "value2": [60, 80, 70, 67, 80, 77, 100]
        }
    }
    try:
        segment = get_segment(request)
        return render_template("home/chart.html", segment=segment, data=data)

    except TemplateNotFound:
        return render_template("home/page-404.html"), 404

    except:
        return render_template("home/page-500.html"), 500


@blueprint.route("/chart2")
@login_required
def chart2():
    data = {
        "pic1": {
            "label": ['销量'],
            "value1": ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子'],
            "value2": [5, 20, 36, 10, 10, 20],
        },
        "pic2": {
            "value": [{
                "name": "北京",
                "value": 21,
                "itemStyle": {
                    "areaColor": '#184cff'
                }
            },
                {
                    "name": "天津",
                    "value": 12
                }]
        }

    }
    try:
        segment = get_segment(request)
        return render_template("home/chart2.html", segment=segment, data=data)

    except TemplateNotFound:
        return render_template("home/page-404.html"), 404

    except:
        return render_template("home/page-500.html"), 500


# Helper - Extract current page name from request
def get_segment(request):
    try:

        segment = request.path.split("/")[-1]

        if segment == "":
            segment = "index"

        return segment

    except:
        return None
