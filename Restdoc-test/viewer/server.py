# -*- coding: utf-8 -*-

import os
import sys
import string
import random
from flask import Flask
from flask import request
from flask.json import JSONEncoder
from flask import jsonify

class MiniJSONEncoder(JSONEncoder):
    item_separator = ','
    key_separator = ':'


app = Flask(__name__)

@app.route("/index.html", methods=['GET'])
def get_index():
    html = ''
    html = html + '''
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="robots" content="noindex">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
        <style>
            .bg_aqua {
                background-color: #4fc1e9;
            }

            p {
                text-align: justify;
            }

            .table {
                border-top: none;
            }

            .is_required:after {
                content: " *";
                color: #E9573F;
            }
        </style>
    </head>
    <body>
        <div class="container" style="padding: 20px;">
            <div class="row">
                <div class="col-md-12">
    '''

    with open('out.txt', 'r') as generated:
        html = html + generated.read()

    html = html + '''
                </div>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css"></script>
    </body>

    </html>
    '''

    return html, 200

HOST = '0.0.0.0'
if __name__ == '__main__':
    args = sys.argv[1:]
    if args:
        HOST = args[0]

    app.json_encoder = MiniJSONEncoder
    app.config['JSONIFY_PRETTYPRINT_REGULAR'] = False
    app.run(host=HOST, port=8888, debug=True, threaded=True)