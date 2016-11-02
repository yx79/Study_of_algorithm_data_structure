//
//  main.m
//  Enums
//
//  Created by Pomme on 11/1/16.
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>

typedef enum {
    FORD,
    HONDA,
    PORSCHE,
    BMW,
    TESLA
} CarModel;

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        CarModel myCar = FORD;
        switch (myCar) {
            case FORD:
            case PORSCHE:
                NSLog(@"You like Western cars?");
                break;
            case HONDA:
                NSLog(@"You like Japanese cars?");
                break;
            default:
                break;
        }
    }
    return 0;
}
