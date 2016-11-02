//
//  main.m
//  Struct
//
//  Struct is like a simple, primitive C object.
// It lets you aggregate several variables into a more complex data structure, but doesn;t provide any OOP features, (e.g. methods). For example, the following snippet uses a struct to group the components of an RGB color.

//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>

typedef struct{
    unsigned char red;
    unsigned char green;
    unsigned char blue;
    
} Color;

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        Color carColor = {255, 160, 0}; // initializer syntax
        NSLog(@"You paint job is (R: %hhu, G: %hhu, B: %hhu)", carColor.red, carColor.green, carColor.blue); // each field can be accessed via dot-synax
    }
    return 0;
}
