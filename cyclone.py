# Name: Claire Winogrodzki
# Date: 11/16/2021
# Class: CSC 3110
# Pledge: I have neither given nor received 
# unauthorized aid on this program.
# 
# Description: Cyclone is a program that classifies
# the category of a hurricane or typhoon based
# on the wind speed entered by the user. The program
# will also determine the wind speed in the opposite
# unit (km or mph) of the input.
# Input: The user enters the wind speed, followed by 
# their unit of choice, either miles or kilometers.
# Users may enter m, M, k, K or spell out the word.
# Output: The program will display the category
# on both the hurricane and typhoon scales.
#
# Notes: I used Python 2.7, and I coded with Sublime Text and the terminal.

#declare global identifiers
units = 0
speed = 0
kSpeed = 0
mSpeed = 0
scale = 0

#determine if hurricane scale or typhoon scale should be used. Set scale identifier
def getScale(units):
   global scale
   if units == 'm' or units == 'M' or units == 'miles':
      scale = 'hurricane'
   elif units == 'k'or units == 'K' or units == 'kilometers':
      scale = 'typhoon'

#get hurricane category
def hurricaneCat(mSpeed):
   if mSpeed < 39: return 'tropical depression'
   elif mSpeed < 74: return 'tropical storm'
   elif mSpeed < 96: return 'category 1 hurricane'
   elif mSpeed < 111: return 'category 2 hurricane'
   elif mSpeed < 130: return 'category 3 hurricane'
   elif mSpeed < 157: return 'category 4 hurricane'
   else: return 'category 5 hurricane'

#get typhoon category
def typhoonCat(kSpeed):
   if kSpeed < 63: return 'tropical depression'
   elif kSpeed < 88: return 'tropical storm'
   elif kSpeed < 118: return 'severe tropical storm'
   elif kSpeed < 150: return 'typhoon'
   elif kSpeed < 185: return'severe typhoon'
   else: return 'super typhoon'

#get opposite unit conversion
def convertUnits(speed):
   global kSpeed
   global mSpeed
   if scale == 'hurricane':
      kSpeed = float(speed) * 1.609344
      mSpeed = int(speed)  #this sets the other variable to be used in ___Cat() function
      return str(kSpeed) + ' km/h'

   elif scale == 'typhoon':
      mSpeed = float(speed) / 1.609344
      kSpeed = int(speed)
      return str(mSpeed) + ' mph'

def main():
   print('Determine hurricane or typhoon category'
      '\n------------------------------------------------------------'
      '\nDo you want to enter miles per hour or kilometers per hour? (enter m or k)')
   
   units = raw_input()
   
   #error handling- validate input
   while units != 'm' and units != 'M' and units != 'miles' and units != 'k' and units != 'K' and units != 'kilometers':
      print("Please enter m or k")
      units = raw_input()

   getScale(units)

   print('What is the speed of the ' + scale + '?')
   speed = raw_input()
   
   #error handling- validate input
   while speed.isdigit() is False or speed < 0:
      print("Please enter a valid speed")
      speed = raw_input()


   #Output
   print('This is ' + convertUnits(speed) +
      '\nOn the hurricane scale, this is a ' + hurricaneCat(mSpeed) +
      '\nOn the typhoon scale, this is a ' + typhoonCat(kSpeed))

if __name__ == "__main__":
    main()







