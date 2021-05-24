from __future__ import division, print_function
from flask import Flask, render_template, request, redirect
from utils import disease

# coding=utf-8
import sys
import os
import glob
import re

# Keras
import numpy as np
import matplotlib.pyplot as plt
import tensorflow as tf
from tensorflow.keras import layers
from keras.layers import Dense , Conv2D , MaxPooling2D , Dropout,Flatten,Convolution2D
from time import perf_counter 
from keras.preprocessing import image

# Flask utils
from werkzeug.utils import secure_filename
from gevent.pywsgi import WSGIServer


app=Flask(__name__)


# Model saved with Keras model.save()
MODEL_PATH = 'models/model1.h5'

# Load your trained model
model = tf.keras.models.load_model(MODEL_PATH)

print('Model loaded. Check http://127.0.0.1:5000/')


def model_predict(img_path, model):

    class_name1=['Apple___Apple_scab',
 'Apple___Black_rot',
 'Apple___Cedar_apple_rust',
 'Apple___healthy',
 'Blueberry___healthy',
 'Cherry_(including_sour)___Powdery_mildew',
 'Cherry_(including_sour)___healthy',
 'Corn_(maize)___Cercospora_leaf_spot Gray_leaf_spot',
 'Corn_(maize)___Common_rust_',
 'Corn_(maize)___Northern_Leaf_Blight',
 'Corn_(maize)___healthy',
 'Grape___Black_rot',
 'Grape___Esca_(Black_Measles)',
 'Grape___Leaf_blight_(Isariopsis_Leaf_Spot)',
 'Grape___healthy',
 'Orange___Haunglongbing_(Citrus_greening)',
 'Peach___Bacterial_spot',
 'Peach___healthy',
 'Pepper,_bell___Bacterial_spot',
 'Pepper,_bell___healthy',
 'Potato___Early_blight',
 'Potato___Late_blight',
 'Potato___healthy',
 'Raspberry___healthy',
 'Soybean___healthy',
 'Squash___Powdery_mildew',
 'Strawberry___Leaf_scorch',
 'Strawberry___healthy',
 'Tomato___Bacterial_spot',
 'Tomato___Early_blight',
 'Tomato___Late_blight',
 'Tomato___Leaf_Mold',
 'Tomato___Septoria_leaf_spot',
 'Tomato___Spider_mites Two-spotted_spider_mite',
 'Tomato___Target_Spot',
 'Tomato___Tomato_Yellow_Leaf_Curl_Virus',
 'Tomato___Tomato_mosaic_virus',
 'Tomato___healthy']

    img = image.load_img(img_path, target_size=(250, 250))
    # return preds
    img = image.img_to_array(img)
    img = np.expand_dims(img, axis=0)
    prediction =model.predict(img)
    prediction = np.argmax(prediction,axis=1)
    preds=class_name1[prediction[0]]
    return preds


#=========== url handlers ====================

@app.route('/')
def home():
    return render_template('index.html',title='Home')

@app.route('/disease-predict', methods=['GET'])
def disease_prediction():
    return render_template('disease2.html', title='Disease Detection')

@app.route('/predict', methods=['GET', 'POST'])
def upload():
    if request.method == 'POST':
        # Get the file from post request
        f = request.files['file']

        # Save the file to ./uploads
        basepath = os.path.dirname(__file__)
        file_path = os.path.join(
            basepath, 'uploads', secure_filename(f.filename))
        f.save(file_path)

        # Make prediction
        preds = model_predict(file_path, model)
        val=disease.getCure(preds)
        print(preds)
        return val

    return None

if __name__ == '__main__':
    app.run(debug=True)