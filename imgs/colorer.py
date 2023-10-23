from PIL import Image

name = "text_ot_"
color_change1 = [228,153,80]
color_change2 = [0,0,0]

for i in range(1):
    for j in range(1,4):
        im = Image.open(name + str(i) + "_" + str(j) + ".png")
        pix = im.load()

        [x_max, y_max] = im.size
        for x in range(x_max):
            for y in range(y_max):
                if(pix[x,y] == (255, 255, 255)):
                    im.putpixel([x,y], (color_change1[0], color_change1[1], color_change1[2]))
                elif(pix[x,y] == (0, 0, 0)):
                    im.putpixel([x,y], (color_change2[0], color_change2[1], color_change2[2]))
        
        im.save(name + str(i) + "_" + str(j) + ".png")